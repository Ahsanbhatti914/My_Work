<%@page language="java" %>

<%
	
     if(session.getAttribute("email") == null)
	{
		response.sendRedirect("Error.html"); 
    }
%> 

<html>

<head>
    <style>
        body
        {
            background-color: black;
        }
        .container {
            margin: auto;
            display: flex;
            flex-wrap: wrap;
            
        }

        .heading {
            font-size: 2.8em;
			margin-left:1%;
			margin-top:1%;
            margin-right: 40%;
            color: white;
        }

        img
        {
            width: 25%;
            margin-top: 5%;
            filter: invert(100%);
        }

        #dImage {
            height: 80px;
            width: 90px;
            filter: invert(0%);
        }

        #tImage {
            height: 80px;
            width: 90px;
            filter: invert(0%);
        }

        #wImage {
            height: 80px;
            width: 90px;
            filter: invert(0%);
        }

        #bImage {
            height: 80px;
            width: 90px;
            filter: invert(0%);
        }

        #dtImage {
            height: 80px;
            width: 90px;
            filter: invert(0%);
        }

        #thImage {
            height: 80px;
            width: 90px;
            filter: invert(0%);
        }

        .box {

            border: 2px solid white;
            border-radius: 3px;
            width: 4.5%;
			height:1%;
            padding: 5%;
            margin: 0.5%;
            align-items: center;
            display: flex;
            background-color: rgb(1, 183, 255);
            box-shadow: 4px 4px 4px #4b4b4b;
        }


        .box:hover {

            border: 2px solid white;
            border-radius: 3px;
            width: 4.5%;
			height:1%;
            padding: 5%;
            align-items: center;
            display: flex;
            cursor: pointer;
            background-color: rgb(1, 215, 255);
        }

        #logout {
            size: 20px;
            padding-left: 25px;
            padding-right: 25px;
            padding-top: 7px;
            padding-bottom: 7px;
            margin-left: 21%;
            margin-top: 1%;
            font-size: 15px;
            border-radius: 8px;
            font-weight: bold;
            background-color: white;
            border: 2px solid white;
            color:black;
            box-shadow: 4px 4px 4px #4b4b4b;
        }

        #logout:hover {
            size: 35px;
            cursor: pointer;
            padding-left: 25px;
            padding-right: 25px;
            padding-top: 7px;
            padding-bottom: 7px;
            margin-left: 21%;
			margin-top: 1%;
            font-size: 15px;
            border-radius: 8px;
            font-weight: bold;
            border: 2px solid white;
			background-color: rgb(1, 215, 255);
            color: black;
			box-shadow: 4px 4px 4px #4b4b4b;
        }


        .box .tooltiptext {
            visibility: hidden;
            width: 90px;
            background-color: black;
            color: #fff;
            text-align: center;
            padding: 4px;
            border-radius: 6px;
            margin-top: 130px;
            
            position: absolute;
            z-index: 1;
        }

     
        .box:hover .tooltiptext {
            visibility: visible;
        }
    </style>

    <script>
        function Goto(clicked) {
            if (clicked == "deposit") {
                window.location.href = "Deposit.jsp";
            }
            else if (clicked == "transfer") {
                window.location.href = "Transfer.jsp";
            }
            else if (clicked == "withdraw") {
                window.location.href = "Withdraw.jsp";
            }
            else if (clicked == "view_balance") {
                window.location.href = "View_balance.jsp";
            }
            else if (clicked == "view_details") {
                window.location.href = "View_details.jsp";
            }
            else if (clicked == "transaction_histroy") {
                window.location.href = "Transaction_histroy.jsp";
            }

        }
    </script>

    <title>Document</title>
</head>

<body>
    <div class="container">
	<h1 class="heading">WELCOME TO ONLINE BANKING</h1>
        <form onclick="Goto(this.id)" id="deposit" class="box" style="margin-left: 2%;">
            <img src="img/wallet.png" alt="" id="dImage">
            <span class="tooltiptext">Deposit</span>
        </form>
        <form class="box" onclick="Goto(this.id)" id="transfer" class="tooltip">
            <img src="img/debt.png" alt="" id="tImage">
            <span class="tooltiptext">Transfer</span>
        </form>
        <form class="box" onclick="Goto(this.id)" id="withdraw" class="tooltip" style="margin-right: 15%;">
            <img src="img/w.png" alt="" id="wImage">
            <span class="tooltiptext">Withdraw</span>
        </form>

        <img src="img/bb.png" alt="">

        <form class="box" onclick="Goto(this.id)" id="view_balance" style="margin-left: 2%; margin-top: -12%;" class="tooltip">
            <img src="img/save-money.png" alt="" id="bImage">
            <span class="tooltiptext">View Balance</span>
        </form>
        <form class="box" onclick="Goto(this.id)" id="view_details" style=" margin-top: -12%;" class="tooltip">
            <img src="img/dt2.png" alt="" id="dtImage">
            <span class="tooltiptext">View Details</span>
        </form>
        <form class="box" onclick="Goto(this.id)" id="transaction_histroy" style=" margin-top: -12%;" class="tooltip" style="margin-right: 5%;">
            <img src="img/accounting.png" alt="" id="thImage">
            <span class="tooltiptext">Transaction</span>
        </form>

        
    </div>
    <form action="Logout" method="post" class="container">
        <button name="logout" id="logout">Log out</button>
    </form>
</body>

</html>