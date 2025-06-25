package AllSpringSecurityInOne.AllSpringSecurityInOne.service;

import AllSpringSecurityInOne.AllSpringSecurityInOne.dto.PostDTO;
import AllSpringSecurityInOne.AllSpringSecurityInOne.entity.PostEntity;
import AllSpringSecurityInOne.AllSpringSecurityInOne.exception.ResourceNotFoundException;
import AllSpringSecurityInOne.AllSpringSecurityInOne.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;
    private ModelMapper modelMapper;

    public PostService(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    public PostDTO getPostById(int id) {

        PostEntity postEntity =  postRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User Not found with these Id : "+id)
        );

        return modelMapper.map(postEntity,PostDTO.class);

    }

    public List<PostDTO> getAllPosts() {

        List<PostEntity> postEntities = postRepository.findAll();

        return postEntities.stream()
                .map(
                        postEntity -> modelMapper.map(postEntity,PostDTO.class)
                ).toList();

    }

    public PostDTO addPost(PostDTO postDTO) {

        PostEntity postEntity = modelMapper.map(postDTO,PostEntity.class);

        PostEntity post =  postRepository.save(postEntity);

        return modelMapper.map(post,PostDTO.class);

    }
}
