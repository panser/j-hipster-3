package ua.org.gostroy.service;

import ua.org.gostroy.domain.Entry;
import ua.org.gostroy.repository.EntryRepository;
import ua.org.gostroy.web.rest.dto.EntryDTO;
import ua.org.gostroy.web.rest.mapper.EntryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Entry.
 */
@Service
@Transactional
public class EntryService {

    private final Logger log = LoggerFactory.getLogger(EntryService.class);
    
    @Inject
    private EntryRepository entryRepository;
    
    @Inject
    private EntryMapper entryMapper;
    
    /**
     * Save a entry.
     * 
     * @param entryDTO the entity to save
     * @return the persisted entity
     */
    public EntryDTO save(EntryDTO entryDTO) {
        log.debug("Request to save Entry : {}", entryDTO);
        Entry entry = entryMapper.entryDTOToEntry(entryDTO);
        entry = entryRepository.save(entry);
        EntryDTO result = entryMapper.entryToEntryDTO(entry);
        return result;
    }

    /**
     *  Get all the entries.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<Entry> findAll(Pageable pageable) {
        log.debug("Request to get all Entries");
        Page<Entry> result = entryRepository.findAll(pageable); 
        return result;
    }

    /**
     *  Get one entry by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public EntryDTO findOne(Long id) {
        log.debug("Request to get Entry : {}", id);
        Entry entry = entryRepository.findOne(id);
        EntryDTO entryDTO = entryMapper.entryToEntryDTO(entry);
        return entryDTO;
    }

    /**
     *  Delete the  entry by id.
     *  
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Entry : {}", id);
        entryRepository.delete(id);
    }
}
