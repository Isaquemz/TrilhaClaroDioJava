package edu.isaque.todotool.mapper;

import edu.isaque.todotool.dto.tag.TagDetailsDTO;
import edu.isaque.todotool.dto.tag.TagResponseDTO;
import edu.isaque.todotool.model.Tag;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TagMapper {

    TagDetailsDTO tagToTagDetailsDTO(Tag tag);

    TagResponseDTO tagToTagResponseDTO(Tag tag);

    Tag toTag(TagDetailsDTO tagDetailsDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    Tag updateTag(Tag updatedTag, @MappingTarget Tag currentTagVersion);

}
