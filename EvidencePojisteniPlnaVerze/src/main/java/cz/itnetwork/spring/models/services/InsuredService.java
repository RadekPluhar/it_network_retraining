package cz.itnetwork.spring.models.services;

import cz.itnetwork.spring.models.dto.InsuredDTO;

import java.util.List;

/**
 * interface for working with the database
 */
public interface InsuredService {

    /**
     * a function for the establishment of the insured
     *
     * @param insured information about the insured from the frontend
     */
    void create(InsuredDTO insured);

    /**
     * retrieves the insured from the database
     *
     * @return all insured persons from the database
     */
    List<InsuredDTO> getAll();

    /**
     * @param insuredId record id (insured id) in the database
     * @return information about the insured from the database
     */
    InsuredDTO getById(long insuredId);

    /**
     * edits the insured in the database
     *
     * @param insured information about the insured from the frontend
     */
    void edit(InsuredDTO insured);

    /**
     * deletes the insured from the database
     *
     * @param insuredId record id (insured id) in the database
     */
    void remove(long insuredId);
}
