package edu.isaque.todotool.controller;

import edu.isaque.todotool.dto.tag.TagDetailsDTO;
import edu.isaque.todotool.dto.tag.TagResponseDTO;
import edu.isaque.todotool.model.Tag;
import edu.isaque.todotool.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping("")
    public ResponseEntity<List<Tag>> findAll() {
        List<Tag> tags = tagService.findAll();
        return ResponseEntity.ok().body(tags);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> findById(@PathVariable Long id) {
        Tag tag = tagService.findById(id);
        return ResponseEntity.ok().body(tag);
    }

    @PostMapping("")
    public ResponseEntity<TagResponseDTO> save(@RequestBody TagDetailsDTO tagDetailsDTO) {
        TagResponseDTO tagId = tagService.save(tagDetailsDTO);
        return ResponseEntity.ok().body(tagId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody TagDetailsDTO tagDetailsDTO) {
        tagService.update(id, tagDetailsDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tagService.delete(id);
        return ResponseEntity.ok().build();
    }

}
