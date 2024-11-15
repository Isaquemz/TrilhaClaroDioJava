package edu.isaque.todotool.mapper;

import edu.isaque.todotool.dto.task.TaskRegisterRequestDTO;
import edu.isaque.todotool.dto.task.TaskResponseDTO;
import edu.isaque.todotool.model.Tag;
import edu.isaque.todotool.model.Task;
import edu.isaque.todotool.model.User;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "assignedTo", source = "assignedTo", qualifiedByName = "idToUser")
    @Mapping(target = "tags", source = "tags", qualifiedByName = "idListToTagList")

    Task toTask(TaskRegisterRequestDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    Task updateTask(Task updatedTask, @MappingTarget Task currentTaskVersion);

    @Mapping(target = "assignedTo", source = "assignedTo", qualifiedByName = "userToId")
    @Mapping(target = "createdBy", source = "createdBy", qualifiedByName = "userToId")
    @Mapping(target = "tags", source = "tags", qualifiedByName = "tagListToIdList")
    TaskResponseDTO toTaskResponseDTO(Task task);

    @Named("idToUser")
    default User idToUser(Long id) {
        if (id == null) return null;
        User user = new User();
        user.setId(id); // Apenas define o ID
        return user;
    }

    @Named("idListToTagList")
    default List<Tag> idListToTagList(List<Long> ids) {
        return ids == null ? null : ids.stream().map(id -> {
            Tag tag = new Tag();
            tag.setId(id);
            return tag;
        }).collect(Collectors.toList());
    }

    @Named("userToId")
    default Long userToId(User user) {
        if (user == null) return null;
        return user.getId();
    }

    @Named("tagListToIdList")
    default List<Long> tagListToIdList(List<Tag> tags) {
        return tags == null ? null : tags.stream().map(tag -> {
            if (tag == null) return null;
            return tag.getId();
        }).collect(Collectors.toList());
    }

}
