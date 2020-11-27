"use strict";

const output = document.getElementById("activeTickets");
function renderTickets() {
    fetch("/read")
        .then(function (response) {
            return response.json();
        }).then(function (tickets) {
            output.innerHTML = "";
            for (let ticket of tickets) {
                // recreate headers
                const active = document.createElement("h4");
                active.className = "grid-title-one";
                active.innerText = "Active Tickets";
                output.appendChild(active);
                const closed = document.createElement("h4");
                closed.className = "grid-title-two";
                closed.innerText = "Closed Tickets";
                output.appendChild(closed);
                // create card
                const newTicket = document.createElement("div");
                newTicket.className = "card grid-active";
                // create card wrapper
                const card = document.createElement("div");
                card.className = "card-body card-padding";
                // create card title and append
                const title = document.createElement("h5");
                title.className = "card-title";
                title.innerText = ticket.problemTitle;
                card.appendChild(title);
                // create card subtitle and append
                const time = document.createElement("h6");
                time.className = "card-subtitle mb-2 text-muted";
                time.innerText = ticket.ticketCreationTime;
                card.appendChild(time);
                // create card description and append
                const desc = document.createElement("p");
                desc.className = "card-text";
                desc.innerText = ticket.problemDescription;
                card.appendChild(desc);
                // create card upvote count and append
                const votes = document.createElement("h6");
                votes.className = "card-subtitle mb-2 text-muted";
                votes.innerText = "UpVotes: " + ticket.upVotes;
                card.appendChild(votes);
                // add edit button and upvote button
                const edit = document.createElement("a");
                edit.className = "card-link";
                edit.href = "#";
                edit.innerText = "Edit";
                card.appendChild(edit);
                const vote = document.createElement("a");
                vote.className = "card-link";
                vote.href = "#";
                vote.innerText = "UpVote";
                vote.addEventListener("click", function () {
                    addUpVote(ticket.id);
                })
                card.appendChild(vote);
                // append whole card to the container
                newTicket.appendChild(card);
                output.appendChild(newTicket);
            }

            //console.log("Ticket: ", tickets);
        }).catch(function (error) {
            console.log(error);
        });
}

renderTickets();


const form = document.getElementById("createTicket")

form.addEventListener("submit", function (event) {
    event.preventDefault();

    const data = {
        email: form.userEmail.value,
        topic: form.topic.value,
        dasId: form.dasId.value,
        department: form.dept.value,
        problemTitle: form.title.value,
        problemDescription: form.description.value
    }

    fetch("/create", {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(function (response) {
            return response.json();
        })
        .then(function (ticket) {
            console.log("ticket: ", ticket);
            form.reset();
        })
        .catch(function (error) {
            console.error(error);
        })
})

function addUpVote(id) {
    fetch("/upVote/" + id, {
        method: "PATCH"
    }).then(response => {
        console.log(response);
        renderTickets();
    })
        .catch(error => console.error(error));
}