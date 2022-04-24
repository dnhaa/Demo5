<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script>
            function test(){
                alert('aaaa');
            }
            function validation(){
                email=f.txtemail.value;
                password=f.txtpassword.value;
                fullname=f.txtfullname.value;
                phone=f.txtphone.value;
                pattern=/^[a-zA-Z]+[@][a-zA-Z]+([.][a-zA-Z]+){1,2}$/;
//                pattern1=/^{1,}$/;
//                pattern2=/^[0-9]{10,12}$/; //phone
                
                alert('aaa');
                //test email
                if(!pattern.test(email)){
                    document.getElementById("e1").innerHTML="your email is not valid";
                    return false;
                }else{
                    document.getElementById("e1").innerHTML="";
                }
//                //test password
//                if (!pattern1.test(password) ){
//                    document.getElementById("e2").innerHTML="your password is not valid";
//                    return false;
//                } else {
//                    document.getElementById("e2").innerHTML="";
//                //test full name
//                if (fullname.length == 0){
//                    document.getElementById("e3").innerHTML="your full name is not valid";
//                    return false;
//                } else {
//                    document.getElementById("e3").innerHTML="";
//                    
//                    //test phone number
//                } if (!pattern2.test(phone)){
//                    document.getElementById("e4").innerHTML="your phone number is not valid";
//                    return false;
//                } else {
//                    document.getElementById("e4").innerHTML="";
//                }
                return true;
            }
        </script>
    </head>
    <body>
        <form action="MainController" method="POST" name="f">
            <p>email: <input type="text" name="txtemail" /><span id="e1"></span></p>
            
            <!--pattern="^[a-zA-z]+[@][a-zA-Z]+([.]a-zA-Z+){1,2}$"-->
            <p>password: <input type="password" name="txtpassword" /><span id="e2"></span></p>
            <p>full name: <input type="text" name="txtfullname" /><span id="e3"></span></p>
            <p>phone: <input type="text" name="txtphone" /><span id="e4"></span></p>
            <p>Choose status: 
                <select name="txtstatus">
                    <option value="1">Active</option>
                    <option value="0">Inactive</option>
                </select>
            </p>
            <p>Choose role: 
                <select name="txtrole">
                    <!--<option value="1">admin</option>-->
                    <option value="0">customer</option>
                </select>
            </p>
            <p><input type="submit" value="create account" name="action" onclick="return validation()"/></p>
        </form>
    </body>
</html>
