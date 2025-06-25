package AllSpringSecurityInOne.AllSpringSecurityInOne.security.userService;

import AllSpringSecurityInOne.AllSpringSecurityInOne.exception.ResourceNotFoundException;
import AllSpringSecurityInOne.AllSpringSecurityInOne.security.entity.UserEntity;
import AllSpringSecurityInOne.AllSpringSecurityInOne.security.userDTO.SignupDTO;
import AllSpringSecurityInOne.AllSpringSecurityInOne.security.userDTO.UserDTO;
import AllSpringSecurityInOne.AllSpringSecurityInOne.security.userRepository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService  implements UserDetailsService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;

    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(
                ()-> new ResourceNotFoundException("User Not Found with this email "+username)
        );
    }

    public Optional<UserEntity> loadUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public UserEntity getUserFromId(int id){
        return userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User Not Found with this id "+id)
        );
    }

    public UserDTO signUp(SignupDTO signupDTO) {

        Optional<UserEntity> user =  userRepository.findByEmail(signupDTO.getEmail());

        System.out.println("--------------------------- "+user);

        if(user.isPresent()){
            throw new ResourceNotFoundException("User Already Present in database "+signupDTO.getEmail());
        }

         UserEntity userEntity  = modelMapper.map(signupDTO,UserEntity.class);
        userEntity.setPassword(passwordEncoder.encode(signupDTO.getPassword()));
         UserEntity userEntity1 = userRepository.save(userEntity);

         return modelMapper.map(userEntity1,UserDTO.class);

    }


}
