package pl.jewusiak.inwentarzeeapi.models.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;

@Builder
@Getter
@Setter
public class EquipmentDto {
    private Long id;
    private String name;
    private String location;
    private String description;
    private LocalDateTime nextCalibration;
    private Collection<AttachmentDto> attachments;
    private Collection<EventDto> events;
}
