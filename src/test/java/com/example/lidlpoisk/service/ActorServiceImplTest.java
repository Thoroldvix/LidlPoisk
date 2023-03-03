package com.example.lidlpoisk.service;

import com.example.lidlpoisk.handler.NotFoundException;
import com.example.lidlpoisk.model.dto.actor.ActorCreateEditDto;
import com.example.lidlpoisk.model.dto.actor.ActorReadDto;
import com.example.lidlpoisk.model.entities.Actor;
import com.example.lidlpoisk.model.entities.Movie;
import com.example.lidlpoisk.repository.ActorRepository;
import com.example.lidlpoisk.repository.MovieRepository;
import com.example.lidlpoisk.service.impl.ActorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ActorServiceImplTest {

    private final Integer ACTOR1_ID = 1;
    private final Integer ACTOR2_ID = 2;

    private final Integer MOVIE1_ID = 1;
    @Mock
    private ActorRepository actorRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private ActorServiceImpl actorService;



    @Test
    void findAll_Should_Work() {
        Actor actor1 = new Actor();
        actor1.setId(ACTOR1_ID);


        Actor actor2 = new Actor();
        actor2.setId(ACTOR2_ID);


        List<Actor> actors = List.of(actor1, actor2);


        when(actorRepository.findAll()).thenReturn(actors);
        when(modelMapper.map(actor1, ActorReadDto.class)).thenReturn(ActorReadDto.builder().id(ACTOR1_ID).build());
        when(modelMapper.map(actor2, ActorReadDto.class)).thenReturn(ActorReadDto.builder().id(ACTOR2_ID).build());


        List<ActorReadDto> result = actorService.findAll();


        assertThat(result).hasSize(2);
        assertThat(result.get(0).getId()).isEqualTo(1);
        assertThat(result.get(1).getId()).isEqualTo(2);
        verify(actorRepository, Mockito.times(1)).findAll();
    }

    @Test
    void findAll_Should_Return_Empty_List() {
        when(actorRepository.findAll()).thenReturn(List.of());

        List<ActorReadDto> result = actorService.findAll();

        assertThat(result).isEmpty();
        verify(actorRepository, Mockito.times(1)).findAll();
    }
    @Test
    void delete_Should_Work() {
        Actor actor = new Actor();
        actor.setId(ACTOR1_ID);

        when(actorRepository.findById(ACTOR1_ID)).thenReturn(Optional.of(actor));

        actorService.delete(ACTOR1_ID);

        verify(actorRepository, Mockito.times(1)).findById(ACTOR1_ID);
        verify(actorRepository, Mockito.times(1)).delete(actor);
    }
    @Test
    void delete_Throws_NotFoundException() {
        when(actorRepository.findById(ACTOR1_ID)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> actorService.delete(ACTOR1_ID));

        verify(actorRepository, Mockito.times(1)).findById(ACTOR1_ID);
        verify(actorRepository, Mockito.times(0)).delete(Mockito.any());
    }
    @Test
    void create_Should_Work() {
        ActorCreateEditDto actorCreateEditDto = new ActorCreateEditDto();
        actorCreateEditDto.setMovieId(MOVIE1_ID);

        Actor actor = new Actor();
        Movie movie = new Movie();
        movie.setId(MOVIE1_ID);

        when(movieRepository.findById(MOVIE1_ID)).thenReturn(Optional.of(movie));
        when(modelMapper.map(actorCreateEditDto, Actor.class)).thenReturn(actor);
        when(actorRepository.save(actor)).thenReturn(actor);



        actorService.create(actorCreateEditDto);

        verify(movieRepository, Mockito.times(1)).findById(1);
        verify(modelMapper, Mockito.times(1)).map(actorCreateEditDto, Actor.class);
        verify(movieRepository, Mockito.times(1)).save(movie);
        verify(actorRepository, Mockito.times(1)).save(actor);
    }
    @Test
    void create_Throws_NotFoundException() {
        ActorCreateEditDto actorCreateEditDto = new ActorCreateEditDto();
        actorCreateEditDto.setMovieId(MOVIE1_ID);

        when(movieRepository.findById(MOVIE1_ID)).thenThrow( NotFoundException.class);

        assertThrows(NotFoundException.class, () -> actorService.create(actorCreateEditDto));

        verify(movieRepository, Mockito.times(1)).findById(1);
        verify(modelMapper, Mockito.times(0)).map(Mockito.any(), Mockito.any());
        verify(movieRepository, Mockito.times(0)).save(Mockito.any());
        verify(actorRepository, Mockito.times(0)).save(Mockito.any());
    }
}

