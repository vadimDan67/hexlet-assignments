package exercise.mapper;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.model.Task;
import exercise.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class TaskMapper {
    @Autowired
    private UserRepository userRepository;
    @Mapping(target = "assignee.id", source = "assigneeId")
    public abstract Task map(TaskCreateDTO dto);
    @Mapping(source = "assignee.id", target = "assigneeId")
    public abstract TaskDTO map(Task model);
    @Mapping(target= "assignee", source = "assigneeId", qualifiedByName = "getUserById")
    public abstract void update(TaskUpdateDTO dto, @MappingTarget Task model);
    @Named("getUserById")
    public User getUserById(Long id) {
        if (id == null) {
            return null;
        } else {
            return userRepository.findById(id).orElse(null);
        }
    }
}
