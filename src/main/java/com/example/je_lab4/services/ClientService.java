package com.example.je_lab4.services;

import com.example.je_lab4.model.*;
import com.example.je_lab4.repositories.*;
import com.example.je_lab4.repositories.clientAttributes.CharactersRepository;
import com.example.je_lab4.repositories.clientAttributes.RequirementsRepository;
import com.example.je_lab4.repositories.clientAttributes.HobbiesRepository;
import com.example.je_lab4.repositories.dates.*;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientDateInfoRepository clientDateInfoRepository;
    private final ClientIdNameSurnameRepository CINSR;
    private final ClientByIdRepository clientByIdRepository;
    private final AllClientsWithoutId clientsWithoutId;
    private final CountryRepository countryRepository;
    private final NewDateRepository newDateRepository;
    private final FindDateByIdDateRepository findDateByIdDateRepository;
    private final UpdateDateRepository updateDateRepository;
    private final DeleteDateRepository deleteDateRepository;
    private final HobbiesRepository hobbiesRepository;
    private final RequirementsRepository requirementsRepository;
    private final CharactersRepository charactersRepository;
    private final SortedClientsRepository sortedClientsRepository;


    public List<ClientsReqsHobbs> getClients() {
        return clientRepository.getClientsWithReqsHobbs();
    }

    public List<ClientsReqsHobbs> getAllOtherClients(int id) {
        return clientsWithoutId.getClientsWithoutId(id);
    }

    public List<Hobbies> getHobbies() {
        return hobbiesRepository.getHobbyList();
    }

    public List<Requirements> getRequirements() {
        return requirementsRepository.getRequirementsList();
    }

    public List<Characters> getCharacters() {
        return charactersRepository.getTraitsList();
    }

    public ClientById getClientById(int id){
        return clientByIdRepository.getClientById(id);
    }

    public ClientIdNameSurname getNameSurnameById(int id) {return CINSR.getClientNameSurname(id);}

    public List<DatesInfo> getDatesInfo(int id){
        return clientDateInfoRepository.getDateInfo(id);
    }

    public List<CountryList> getCountries() {return countryRepository.getCountryList();}

    @Transactional
    public void addDate(int firstid, int secondid, LocalDateTime date, int country) {
        newDateRepository.getDateList(firstid, secondid, date, country);
    }

    public DatesInfo getDateByIdInfo(int dateId) {
        return findDateByIdDateRepository.findDateById(dateId);
    }

    @Transactional
    public void updateDate(int dateId, LocalDateTime date) {
        updateDateRepository.updateDate(dateId, date);
    }


    public List<ClientsReqsHobbs> getSortedClients(String sortBy) {
        return sortedClientsRepository.getClientsWithReqsHobbsSortedByName(sortBy);
    }

    @Transactional
    public void deleteDate(int dateId) {
        deleteDateRepository.deleteDate(dateId);
    }
}
