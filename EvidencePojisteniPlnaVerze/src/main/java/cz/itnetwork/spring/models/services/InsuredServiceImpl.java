package cz.itnetwork.spring.models.services;

import cz.itnetwork.spring.data.entities.InsuredEntity;
import cz.itnetwork.spring.data.repositories.InsuredRepository;
import cz.itnetwork.spring.models.dto.InsuredDTO;
import cz.itnetwork.spring.models.dto.mappers.InsuredMapper;
import cz.itnetwork.spring.models.exceptions.InsuredNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

/**
 * implementing functions from the InsuredService interface
 */
@Service
public class InsuredServiceImpl implements InsuredService {

    /**
     * an interface for working with the database
     */
    @Autowired
    private InsuredRepository insuredRepository;

    /**
     * an interface for transferring data from the frontend to the database and back
     */
    @Autowired
    private InsuredMapper insuredMapper;

    /**
     * a function for the establishment of the insured
     *
     * @param insuredDTO information about the insured from the frontend
     */
    @Override
    public void create(InsuredDTO insuredDTO) {
        InsuredEntity newInsured = insuredMapper.toEntity(insuredDTO);

        insuredRepository.save(newInsured);
    }

    /**
     * retrieves the insured from the database
     *
     * @return all insured persons from the database
     */
    @Override
    public List<InsuredDTO> getAll() {
        return StreamSupport.stream(insuredRepository.findAll().spliterator(), false)
                .map(i -> insuredMapper.toDTO(i))
                .toList();
    }

    /**
     * @param insuredId record id (insured id) in the database
     * @return information about the insured from the database
     */
    @Override
    public InsuredDTO getById(long insuredId) {
        InsuredEntity fetchedInsured = getInsuredOrThrow(insuredId);

        return insuredMapper.toDTO(fetchedInsured);
    }

    /**
     * edits the insured in the database
     *
     * @param insured information about the insured from the frontend
     */
    @Override
    public void edit(InsuredDTO insured) {
        InsuredEntity fetchedInsured = getInsuredOrThrow(insured.getInsuredId());

        insuredMapper.updateInsuredEntity(insured, fetchedInsured);
        insuredRepository.save(fetchedInsured);
    }

    /**
     * deletes the insured from the database
     *
     * @param insuredId record id (insured id) in the database
     */
    @Override
    public void remove(long insuredId) {
        InsuredEntity fetchedEntity = getInsuredOrThrow(insuredId);
        insuredRepository.delete(fetchedEntity);
    }

    /**
     * this function handles exceptions
     *
     * @param insuredId record id (insured id) in the database
     * @return record (of the insured) in the database
     */
    private InsuredEntity getInsuredOrThrow(long insuredId) {
        return insuredRepository
                .findById(insuredId)
                .orElseThrow(InsuredNotFoundException::new);
    }
}
