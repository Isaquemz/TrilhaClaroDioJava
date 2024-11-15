package edu.isaque.todotool.service;

import edu.isaque.todotool.dto.tag.TagDetailsDTO;
import edu.isaque.todotool.dto.tag.TagResponseDTO;
import edu.isaque.todotool.exception.TagNotFoundException;
import edu.isaque.todotool.exception.TaskNotFoundException;
import edu.isaque.todotool.mapper.TagMapper;
import edu.isaque.todotool.model.Tag;
import edu.isaque.todotool.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    public Tag findById(Long id) {
        return tagRepository.findById(id)
            .orElseThrow(() -> new TaskNotFoundException("Tag not found"));
    }

    public TagResponseDTO save(TagDetailsDTO tagDetailsDTO) {
        Tag tag = tagMapper.toTag(tagDetailsDTO);
        Tag tagSaved = tagRepository.save(tag);
        return tagMapper.tagToTagResponseDTO(tagSaved);
    }

    public void update(Long id, TagDetailsDTO tagDetailsDTO) {
        Tag currentTagVersion = tagRepository.findById(id)
                .orElseThrow(() -> new TagNotFoundException("Tag not found"));
        Tag updatedTag = tagMapper.toTag(tagDetailsDTO);
        Tag tagToSave = tagMapper.updateTag(updatedTag, currentTagVersion);
        tagRepository.save(tagToSave);
    }

    public void delete(Long id) {
        Tag tag = tagRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Tag not found"));
        tagRepository.delete(tag);
    }

}
