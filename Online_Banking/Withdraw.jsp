<%@page language="java" %>

<%
	
     if(session.getAttribute("email") == null)
	{
		response.sendRedirect("Error.html"); 
    }
%> 
<html>

<head>
    <title>Withdraw</title>
    <style>
        body
        {
            background-color: black;
        }
        
        h1 {
            margin-left: 34%;
            margin-bottom: 1%;
            margin-top: 1%;
            font-size: 30pt;
            color: white;
        }

        img
        {
            width: 17%;
            margin-left: 45%;
            margin-top: 5%;
            filter: invert(100%);
        }

        .input_field {

            margin-left: 37%;
            margin-top: 1%;
            font-size: 15px;
            width: 32%;
            padding-left: 0px;
            padding-right: 0px;
            padding-top: 2px;
            padding-bottom: 2px;
            text-align: center;
            background-color: rgb(1, 183, 255);
            color: white;
            border-radius: 8px;
            padding: 4px;
        }

        ::placeholder {
            color: white;
            font-weight: bold;
			opacity:1;
        }

        .error {
            color: red;
        }

        #submit {
            size: 40px;
            font-weight: bold;
            padding-left: 20px;
            padding-right: 20px;
            padding-top: 7px;
            padding-bottom: 7px;
            margin-left: 49.3%;
            margin-top: 1%;
            font-size: 15px;
            background-color: white;
            border: 2px solid white;
            color:black;
            border-radius: 8px;
        }

        #submit:hover {
            size: 40px;
            font-weight: bold;
            cursor: pointer;
            border: 2px solid white;
			background-color: rgb(1, 215, 255);
            color: black;
            padding-left: 20px;
            padding-right: 20px;
            padding-top: 7px;
            padding-bottom: 7px;
            margin-left: 49.3%;
            margin-top: 1%;
            font-size: 15px;
            border-radius: 8px;
        }

    </style>
    <script>
        function validation() {
            if (document.getElementById("amount").value == "") {
                document.getElementById("amount_error").innerHTML = "Amount is empty!!";
		document.getElementById("amount").style.border = "2px solid red";
                return false;
            }
            else 
            {
                let n = document.getElementById("amount").value;
               flag = 0;
               for(i = 0; i < n.length ; i++)
               {
                    if(n[i] == ".")
                    {
                        flag++;
                        if(!((n.lastIndexOf(".")-n.indexOf(".")) == 0))
                        {
                            	document.getElementById("amount_error").innerHTML = "Invalid input type";
				document.getElementById("amount").style.border = "2px solid red";
                            	return false;
                        }
                    }
                    else
                    {
                        if(!(n[i] > -1 && n[i] < 10) && flag < 2)
                        {
                            	document.getElementById("amount_error").innerHTML = "Amount must be in digits!!";
				document.getElementById("amount").style.border = "2px solid red";
                            	return false;
                        }
                        
                    }
               }
               if(parseFloat(n) <= 0)
               {
                    	document.getElementById("amount_error").innerHTML = "Amount must be greater than 0.0";
			document.getElementById("amount").style.border = "2px solid red";
                    	return false;
              }
                
            }
	    
            if (document.getElementById("email").value == "") {
                document.getElementById("email_error").innerHTML = "Email is empty!!"
                document.getElementById("email").style.border = "2px solid red";
                return false;
            }
            else {
                let email = document.getElementById("email").value;
                if (!((email.indexOf("@") > 0) && (email.lastIndexOf("@") - email.indexOf("@") == 0) && (email.lastIndexOf(".") - email.indexOf("@")) > 1 && (email.length - email.lastIndexOf(".") > 0))) {

                    document.getElementById("email_error").innerHTML = "Invalid Email!!";
                    document.getElementById("email").style.border = "2px solid red";
                    return false;
                }
                for (i = 0; i < email.length; i++) {
                    flag = email[i];
                    if (email[i + 1] == "." && flag == ".") {
                        document.getElementById("email_error").innerHTML = "Invalid Email!!";
                        document.getElementById("email").style.border = "2px solid red";
                        return false;
                    }
                }


            }
	    if (document.getElementById("password").value == "") {
                document.getElementById("password_error").innerHTML = "Password is empty!!";
		document.getElementById("password").style.border = "2px solid red";
                return false;
            }
        }
    </script>

</head>



<body>
    <img src="img/bb.png" alt="">
    <form onsubmit="return validation()" action="Withdraw" method="post">
	
        <h1 class="heading">WITHDRAW YOUR FUNDS</h1>
        <input class="input_field" name="amount" type="text" id="amount" placeholder="Enter Amount">
        <span class="error" id="amount_error"></span>
        <br>

        <input class="input_field" name="email" type="text" id="email" placeholder="Email ID">
        <span class="error" id="email_error"></span>
        <br>

	<input class="input_field" name="password" type="password" id="password" placeholder="Enter Password">
        <span class="error" id="password_error"></span>
        <br>

        <input type="Submit" value="Withdraw" id="submit">

    </form>

</body>


</html>