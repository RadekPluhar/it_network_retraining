package cz.itnetwork.spring.models.dto.mappers;

import cz.itnetwork.spring.data.entities.InsuredEntity;
import cz.itnetwork.spring.models.dto.InsuredDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * an interface for transferring data from the frontend to the database and back
 */
@Mapper(componentModel = "spring")
public interface InsuredMapper {

    /**
     * functions for writing data to the database
     *
     * @param source data from the user
     * @return new or updated database entry
     */
    InsuredEntity toEntity(InsuredDTO source);

    /**
     * a function that prints a record from the database to the frontend
     *
     * @param source record in the database
     * @return data to the frontend
     */
    InsuredDTO toDTO(InsuredEntity source);

    /**
     * a function that is used for listing and then changing the insured's data on the frontend
     *
     * @param source the original data, read from the database
     * @param target changed data, ready to be sent to the database
     */
    void updateInsuredDTO(InsuredDTO source, @MappingTarget InsuredDTO target);

    /**
     * a function that is used to update data in the database, which it overwrites with changed data from the frontend
     *
     * @param source changed data, ready to be sent to the database
     * @param target overwriting a record in the database
     */
    void updateInsuredEntity(InsuredDTO source, @MappingTarget InsuredEntity target);
}
