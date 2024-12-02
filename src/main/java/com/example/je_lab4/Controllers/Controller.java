package com.example.je_lab4.Controllers;

import com.example.je_lab4.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Objects;


@org.springframework.stereotype.Controller
@AllArgsConstructor
public class Controller {

    private ClientService cs;

    @GetMapping("/")
    public String getClients(Model model) {
        model.addAttribute("clients", cs.getClients());
        model.addAttribute("hobbies", cs.getHobbies());
        model.addAttribute("requirements", cs.getRequirements());
        model.addAttribute("characters", cs.getCharacters());
        return "index";
    }

    @GetMapping("/dates_info")
    public String datesInfo(@RequestParam int id, Model model){
        model.addAttribute("clientinfo",cs.getDatesInfo(id));
        model.addAttribute("id",id);
        model.addAttribute("client",cs.getNameSurnameById(id));
        model.addAttribute("countrylist", cs.getCountries());
        model.addAttribute("clients",cs.getAllOtherClients(id));
        return "dates_info";
    }



    @PostMapping("/add_date")
    public String add_date(@RequestParam int firstid, int secondid, LocalDateTime date, int country, Model model){
        cs.addDate(firstid, secondid, date, country);
        return "redirect:/dates_info?id=" + firstid;
    }

    @GetMapping("/edit_date")
    public String editDate(@RequestParam int date_id, int client_id, Model model) {
        model.addAttribute("dateInfo", cs.getDateByIdInfo(date_id));
        model.addAttribute("client",cs.getNameSurnameById(client_id));
        return "edit_date";
    }

    @PostMapping("/update_date")
    public String updateDate(@RequestParam int date_id, int client_id,
                             @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
                             Model model) {
        cs.updateDate(date_id, date);
        return "redirect:/dates_info?id=" + client_id;
    }

    @PostMapping("/delete_date")
    public String delete_date(@RequestParam int date_id, @RequestParam int client_id, Model model) {
        cs.deleteDate(date_id);
        System.out.println("DATE DELETED");
        return "redirect:/dates_info?id=" + client_id;
    }


    @GetMapping("/sortedClients")
    public String getSortedClients(@RequestParam(required = false) String sort, Model model) {
        if (sort != null) {
            model.addAttribute("clients", cs.getSortedClients(sort));
            model.addAttribute("hobbies", cs.getHobbies());
            model.addAttribute("requirements", cs.getRequirements());
            model.addAttribute("characters", cs.getCharacters());
        }
        if (Objects.equals(sort, "id")){
            return getClients(model);
        }
        return "index";
    }

}
