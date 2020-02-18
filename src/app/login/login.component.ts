import { Component, OnInit } from '@angular/core';
import { LoginDTO } from 'src/dto/logindto';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router';
import { UserDTO } from 'src/dto/userdto';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginDTO: LoginDTO;

  constructor(private service: UserService, private router: Router) { }

  ngOnInit() {
  }
  visibile(){
    document.getElementById("user").setAttribute("class","menuVisibile");
    document.getElementById("pass").setAttribute("class","menuVisibile");
    document.getElementById("enter").setAttribute("style","visibility: visible;")
  }
  muovi(){
    document.getElementById("transizione").setAttribute("class","transizioneC");
    setTimeout(this.visibile,1000)
  
  }
 
   

  login(f: NgForm): void {
    this.loginDTO = new LoginDTO(f.value.username, f.value.password);

    this.service.login(this.loginDTO).subscribe((token : any) => {
      localStorage.setItem("AUTOKEN", JSON.stringify({ "authorities": token.id_token }));
      localStorage.setItem("currentUser", JSON.stringify({ "authorities": token.id_token }));
      this.service.userLogged(this.loginDTO.username).subscribe((user:UserDTO)=>{

      if (user != null) {
        localStorage.setItem('AUTOKEN', JSON.stringify(user));
        console.log(user.authorities);
        if(user.authorities == "ROLE_ADMIN" ) {
          this.router.navigate(['/admin-dashboard']);
        }
        if(user.authorities == "ROLE_USER") {
          this.router.navigate(['/user-dashboard']);
        }
      }else{
          alert("Wrong username or password");
        }
      });
    });
    }
}
