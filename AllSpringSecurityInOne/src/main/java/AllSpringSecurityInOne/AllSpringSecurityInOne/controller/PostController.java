package AllSpringSecurityInOne.AllSpringSecurityInOne.controller;

import AllSpringSecurityInOne.AllSpringSecurityInOne.dto.PostDTO;
import AllSpringSecurityInOne.AllSpringSecurityInOne.response.ApiResponse;
import AllSpringSecurityInOne.AllSpringSecurityInOne.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/post")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> TestServer(){
        return ResponseEntity.ok(new ApiResponse("Server tested successfully"));
    }

    @GetMapping(path = "/getPostById/{id}")
    public ResponseEntity<ApiResponse> getPostById(@PathVariable  int id){

        PostDTO result = postService.getPostById(id);

        return ResponseEntity.ok(new ApiResponse(result));

    }

    @GetMapping(path = "/getAllPosts")
    public ResponseEntity<ApiResponse> getAllPosts(){

        List<PostDTO> result =  postService.getAllPosts();
        return ResponseEntity.ok(new ApiResponse(result));
    }

    @PostMapping(path = "/addPost")
    public ResponseEntity<ApiResponse> addPost(@RequestBody  PostDTO postDTO){

        PostDTO result = postService.addPost(postDTO);
        return ResponseEntity.ok(new ApiResponse(result));
    }

}
