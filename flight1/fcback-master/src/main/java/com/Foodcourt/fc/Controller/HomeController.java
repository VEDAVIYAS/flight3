package com.Foodcourt.fc.Controller;

import com.Foodcourt.fc.Entity.Bookings;
import com.Foodcourt.fc.Entity.Flight;
import com.Foodcourt.fc.Entity.Roles;
import com.Foodcourt.fc.Entity.User;
import com.Foodcourt.fc.Repository.RoleRepository;
import com.Foodcourt.fc.Repository.UserRepository;
import com.Foodcourt.fc.dto.*;
import com.Foodcourt.fc.mapper.LoginMapper;
import com.Foodcourt.fc.service.BookingsService;
import com.Foodcourt.fc.service.FlightService;
import com.Foodcourt.fc.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class HomeController {


    @Autowired
    LoginMapper loginMapper;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FlightService flightService;

    @Autowired
    BookingsService bookingsService;

    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginDTO loginDTO, HttpServletResponse request){
        String s;
        s="USER";
        if(loginDTO.getEmail().equals("santhosha.20cse@kongu.edu")) {
            s = "ADMIN";
        }
        return new ResponseEntity<>(loginMapper.createAuthenticationToken(loginDTO,request)+" "+s,HttpStatus.OK);
    }

    @PostMapping("/signup")
    public void signup(@RequestBody UserDTO userDTO)
    {
        User user = userRepository.findByEmail(userDTO.getEmail());
        if(user!=null){
            return;
        }
        Roles roles1=new Roles("USER");
        roleRepository.save(roles1);
        List<Roles> roles=new ArrayList<>();
        roles.add(roles1);
        userRepository.save(new User(userDTO.getEmail(), passwordEncoder.encode(userDTO.getPassword()),roles));

    }

    @PostMapping("/logout")
    public ResponseEntity<Object> logout(HttpServletRequest request){
        jwtUtil.logout(request);
        return new ResponseEntity<>("Admin logged out.",HttpStatus.OK);
    }

    @PostMapping(value =  "addFlight", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addFlight(@RequestBody FlightDTO flightDTO)
    {
        flightService.saveFlight(flightDTO);
        return new ResponseEntity<>("saved",HttpStatus.OK);
    }

    @GetMapping("/everyFlight")
    public List<Flight> everyFlight()
    {
        return flightService.fetchAll();
    }

    @GetMapping("/deleteFlight")
    public void deleteFlight(@RequestParam("id") int id)
    {
        System.out.println(id);
        flightService.deleteById(id);
    }


    @PostMapping("/addBooking")
    public String addBooking(@RequestBody BookingsDTO bookingsDTO)
    {
        return bookingsService.saveBooking(bookingsDTO);

    }

    @PostMapping("/userBooking")
    public ResponseEntity<List<UserBookingDTO>> userBooking()
    {
        List<UserBookingDTO> lst = bookingsService.getUserBooking();
        System.out.println(lst);
        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    @PostMapping("/flightBooking")
    public ResponseEntity<Object> flightBooking(@RequestParam("flightId") int flightId)
    {
        return new ResponseEntity<>(bookingsService.getFlightBooking(flightId),HttpStatus.OK);
    }

    @GetMapping("/filter-by-date")
    public ResponseEntity<List<Flight>> filter(@RequestParam("departure_time") String departure_time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        Date date = sdf.parse(departure_time);
        System.out.println(date);
        List<Flight> res = flightService.getFlightsByDate(date);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @GetMapping("/flightName")
    public ResponseEntity<List<String>> flightName()
    {
        return new ResponseEntity<>(flightService.getNames(),HttpStatus.OK);
    }

    @GetMapping("/filter-by-name")
    public ResponseEntity<List<Flight>> filterName(@RequestParam("flightName") String flightName)
    {
        return new ResponseEntity<>(flightService.filterByName(flightName),HttpStatus.OK);
    }

    @PostMapping("/filtering-BY-All")
    public ResponseEntity<List<Flight>> filtering(@RequestBody FilteringDTO filteringDTO)  throws ParseException
    {
        Date date=null;
        if(filteringDTO.getDepartureTime()!=null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            date = sdf.parse(filteringDTO.getDepartureTime());
        }
        return new ResponseEntity<>(flightService.filteringByAll(filteringDTO,date),HttpStatus.OK);
    }
}
