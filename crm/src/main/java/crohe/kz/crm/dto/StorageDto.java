package crohe.kz.crm.dto;

import crohe.kz.crm.entity.Staff;
import crohe.kz.crm.entity.Storage;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class StorageDto {
    private Long id;
    private String name;
    private String address;
    private Staff staff;

    public static StorageDto toModal(Storage storage){
        StorageDto storageDto = new StorageDto();
        storageDto.setId(storage.getId());
        storageDto.setName(storage.getName());
        storageDto.setAddress(storage.getAddress());
        storageDto.setStaff(storage.getStaff());
        return storageDto;
    }

    public static List<StorageDto> toModal(List<Storage> storages){
        List<StorageDto> storageDtoList;
        storageDtoList = storages.stream().map(StorageDto::toModal).collect(Collectors.toList());
        return storageDtoList;
    }
}
