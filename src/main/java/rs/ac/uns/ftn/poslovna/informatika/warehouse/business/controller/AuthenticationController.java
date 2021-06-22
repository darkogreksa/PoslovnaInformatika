package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.LoginDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.TokenDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.security.TokenUtils;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation.UserDetailsServiceImpl;

@RestController
@RequestMapping(value = "api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    TokenUtils tokenUtils;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO) {
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    loginDTO.getUsername(), loginDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(token);
            UserDetails details = userDetailsService.loadUserByUsername(loginDTO.getUsername());
            return new ResponseEntity<TokenDTO>(new TokenDTO(tokenUtils.generateToken(details)), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<TokenDTO>(new TokenDTO(), HttpStatus.BAD_REQUEST);
        }
    }

}
