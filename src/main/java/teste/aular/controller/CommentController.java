package teste.aular.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teste.aular.domain.contract.CommentRepository;
import teste.aular.domain.contract.HotelRepository;
import teste.aular.domain.contract.PetTutorRepository;
import teste.aular.domain.entity.Hotel;
import teste.aular.domain.entity.PetTutor;
import teste.aular.domain.vo.Comment;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PetTutorRepository petTutorRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @PostMapping
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {
        Optional<PetTutor> petTutor = this.petTutorRepository.findPetTutorByUUID(comment.getAuthor().getPetTutorUuid());
        Optional<Hotel> hotel = this.hotelRepository.findById(comment.getHotel().getHotelId());

        comment.setAuthor(petTutor.get());
        comment.setHotel(hotel.get());

        this.petTutorRepository.save(petTutor.get());
        this.hotelRepository.save(hotel.get());

        this.commentRepository.save(comment);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getComments(@PathVariable String hotelUuid) {
        Optional<List<Comment>> comments = this.commentRepository.getCommentsByHotelUuid(hotelUuid);

        return comments.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(comments.get());
    }
}
