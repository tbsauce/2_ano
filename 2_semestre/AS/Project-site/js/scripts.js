 /*!
* Start Bootstrap - Agency v7.0.11 (https://startbootstrap.com/theme/agency)
* Copyright 2013-2022 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-agency/blob/master/LICENSE)
*/
//
// Scripts
// 

window.addEventListener('DOMContentLoaded', event => {

    // Navbar shrink function
    var navbarShrink = function () {
        const navbarCollapsible = document.body.querySelector('#mainNav');
        if (!navbarCollapsible) {
            return;
        }
        if (window.scrollY === 0) {
            navbarCollapsible.classList.remove('navbar-shrink')
        } else {
            navbarCollapsible.classList.add('navbar-shrink')
        }

    };

    // Shrink the navbar 
    navbarShrink();

    // Shrink the navbar when page is scrolled
    document.addEventListener('scroll', navbarShrink);

    // Activate Bootstrap scrollspy on the main nav element
    const mainNav = document.body.querySelector('#mainNav');
    if (mainNav) {
        new bootstrap.ScrollSpy(document.body, {
            target: '#mainNav',
            offset: 74,
        });
    };

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });

});

function add_pet(){
    var pet_name = document.getElementById('aname').value;
    var pet_weight = document.getElementById('aweight').value;
    var pet_age = document.getElementById('aage').value;
    sessionStorage.setItem("Name_a", pet_name);
    sessionStorage.setItem("Weight", pet_weight);
    sessionStorage.setItem("Age", pet_age);
}

function login1()
{
    var u = "filipe"
    var p = "freixo";    
    
    var username = document.getElementById('uname').value;
    //var password = document.getElementById('psw').value;
    //sessionStorage.setItem("currentloggedin", username);
    
    
        if(username!=null){
            
            //alert('Login successful');
            //window.location.href = "/home/filipe/Desktop/AS/index.html"
            sessionStorage.setItem("Name", username);
            sessionStorage.setItem("ref", "Pessoa.html");
            
        }

       
        
         
            
        /*
          if(u === username && p===password)
        {  
        }
 
        else
        {
            alert('Login failed');
            //window.location.href = "/home/filipe/Desktop/AS/login.html"
            sessionStorage.setItem("Name", "Login");
            sessionStorage.setItem("ref", "login.html");

                
        }*/

    //changes inf of person

}








//chnage text login

function logintext(){
    var firstname = document.getElementById("exampleFirstName").value; 
    var lastname = document.getElementById("exampleLastName").value;
    if(firstname != null || lastname != null){
        sessionStorage.setItem("Name", firstname + " " + lastname);
        sessionStorage.setItem("ref", "Pessoa.html");
    }

    

    
}

function logOut(){
    sessionStorage.clear();
}/*

function logintext(){
    var firstname = document.getElementById("exampleFirstName").value; 
    var lastname = document.getElementById("exampleLastName").value;
    var pass = document.getElementById("exampleInputPassword").value;
    if(firstname != null || lastname != null){
        sessionStorage.setItem("Name", firstname + " " + lastname);
        sessionStorage.setItem("ref", "Pessoa.html");
        sessionStorage.setItem("Pass", pass);
    }
}

//Log out clear people


//Login
function Login(){
    var user = document.getElementById("exampleInputName").value;
    var pass = document.getElementById("exampleInputPassword").value;
    if(!(sessionStorage.getItem("Name").localeCompare(user) && sessionStorage.getItem("Name").localeCompare(pass)))
        alert("incorrect");
    else
        alert("correct");
}

//default for login*/
if(sessionStorage.length == 0){
    sessionStorage.setItem("ref", "login.html");
    sessionStorage.setItem("Name", "Login");
    sessionStorage.setItem("Name_a", "Name1");
    sessionStorage.setItem("Weight", "kg");
    sessionStorage.setItem("Age", "anos");
}



document.addEventListener('DOMContentLoaded', function() {
        document.getElementById("navlogin").innerHTML= sessionStorage.getItem("Name"); 
        document.getElementById("navlogin").href= sessionStorage.getItem("ref");
        document.getElementById("name_pessoa").innerHTML= sessionStorage.getItem("Name");
        document.getElementById("pet_name").innerHTML= sessionStorage.getItem("Name_a");
        


    }, false);

