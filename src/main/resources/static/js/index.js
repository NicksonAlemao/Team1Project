"use strict";

const output = document.getElementById("activeTickets");

fetch("/read")
    .then(function (response) {
        return response.json();
    }).then(function (tickets) {

        for (let ticket of tickets) {
            const newTicket = document.createElement("div");
            newTicket.className = "card";
            const card = document.createElement("div");
            card.className = "card-body card-padding";
            const title = document.createElement("h5");
            title.innerText = ticket.problemTitle;
            card.appendChild(title);
            newTicket.appendChild(card);
            output.appendChild(newTicket);
            console.log(output.innerText);

        }



        //console.log("Ticket: ", tickets);
    }).catch(function (error) {
        console.log(error);
    });