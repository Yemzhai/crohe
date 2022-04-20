package crohe.kz.crm.dto;

import crohe.kz.crm.entity.Staff;
import crohe.kz.crm.entity.Storage;
import crohe.kz.crm.enumeration.StaffEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class StaffDto {
    private Long id;
    private StaffEnum position;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String login;
    private String password;
    private List<Storage> storages;


    public static StaffDto toModal(Staff staff){
        StaffDto staffDto = new StaffDto();
        staffDto.setId(staff.getId());
        staffDto.setPosition(staff.getPosition());
        staffDto.setFirstName(staff.getFirstName());
        staffDto.setLastName(staff.getLastName());
        staffDto.setEmail(staff.getEmail());
        staffDto.setPhoneNumber(staff.getPhoneNumber());
        staffDto.setLogin(staff.getLogin());
        staffDto.setPassword(staff.getPassword());
        staffDto.setStorages(staff.getStorages());
        return staffDto;
    }

    public static List<StaffDto> toModal(List<Staff> staff){
        List<StaffDto> userProfileDtoList;
        userProfileDtoList = staff.stream().map(StaffDto::toModal).collect(Collectors.toList());
        return userProfileDtoList;
    }
}
