<%--
  Created by IntelliJ IDEA.
  User: audreytan
  Date: 8/29/23
  Time: 9:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Pizza Order Form</title>
</head>
<body>

<form method="POST" action="pizza.jsp">

    <input type ="text" name="username" placeholder="Enter your name">
    <input type ="text" name="address" placeholder="Enter your address for pickup or delivery">
    <label for="pickup">Pickup Order</label>
    <input id="pickup" type="radio" name="deliver-pickup" value="pickup">
    <label for="deliver">Deliver Order</label>
    <input id="deliver" type="radio" name="deliver-pickup" value="delivery">
    <br>
    <hr>
    <br>
    <h1>Sauce Choices</h1>
<h2> Please choose one sauce for the base of your pizza.</h2>
    <hr>
    <label for="marinara">Marinara Sauce</label>
    <input id="marinara" type="radio" name="sauce" value="Marinara">
    <label for="alfredo">Alfredo Sauce</label>
    <input id="alfredo" type="radio" name="sauce" value="Alfredo">
    <label for="oil">Olive Oil/No Sauce</label>
    <input id="oil" type="radio" name="sauce" value="Oil">
<br>
<h3> How much sauce would you like?</h3>
<label for="light-sauce">Light Sauce</label>
<input id="light-sauce" type="radio" name="sauce-amount" value="light">
<label for="regular-sauce">Regular Sauce</label>
<input id="regular-sauce" type="radio" name="sauce-amount" value="regular">
<label for="more-sauce">More Sauce</label>
<input id="more-sauce" type="radio" name="sauce-amount" value="more">
    <br>

    <h1> Size Choices </h1>
<hr>
<label for="small">Small</label>
<input id="small" type="radio" name="size" value="small">
<label for="medium">Medium</label>
<input id="medium" type="radio" name="size" value="medium">
<label for="large">Large</label>
<input id="large" type="radio" name="size" value="large">
<br>

<h1>Toppings</h1>
    <hr>
<label for="pepperoni">Pepperoni</label>
<input id="pepperoni" type="checkbox" name="toppings" value="Pepperoni">
<label for="bacon">Bacon</label>
<input id="bacon" type="checkbox" name="toppings" value="Bacon">
<label for="chicken">Chicken</label>
<input id="chicken" type="checkbox" name="toppings" value="chicken">
<label for="onions">Onions</label>
<input id="onions" type="checkbox" name="toppings" value="Onions">
<label for="jalapenos">Jalapenos</label>
<input id="jalapenos" type="checkbox" name="toppings" value="jalapenos">
<label for="pineapple">Pineapple</label>
<input id="pineapple" type="checkbox" name="toppings" value="pineapple">
    <br>

    <button type="submit" id="submit-form">Submit</button>

</form>
<script>
    document.getElementById("submit-form").addEventListener('click', ()=>{
        alert("Order sent!");
    })
</script>
</body>
</html>
