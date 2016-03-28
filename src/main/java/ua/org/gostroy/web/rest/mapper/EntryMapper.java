package ua.org.gostroy.web.rest.mapper;

import ua.org.gostroy.domain.*;
import ua.org.gostroy.web.rest.dto.EntryDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Entry and its DTO EntryDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EntryMapper {

    EntryDTO entryToEntryDTO(Entry entry);

    List<EntryDTO> entriesToEntryDTOs(List<Entry> entries);

    Entry entryDTOToEntry(EntryDTO entryDTO);

    List<Entry> entryDTOsToEntries(List<EntryDTO> entryDTOs);
}
