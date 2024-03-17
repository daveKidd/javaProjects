let videoGames = [];
let editVideoGameId = 0;

const formContainerElement = document.getElementById('formContainer');
const listContainerElement = document.getElementById('listContainer');

function handleSubmit(event){
  event.preventDefault();

  const title = document.getElementById("title").value;
  const console = document.getElementById("console").value;
  const price = document.getElementById("price").value;
  const releaseDate = document.getElementById("releaseDate").value;
  const singlePlayer = document.getElementById("singlePlayer").value;

  const videoGame = {
    title,
    console,
    price: price ? parseFloat(price) : 0,
    releaseDate,
    singlePlayer
  }

  if(editVideoGameId > 0){
    editGame(videoGame)
  }else{
    addGame(videoGame)
  }
}

function handleDeleteGame(videoGameId){
  const videoGame = videoGames.find(videoGame => videoGame.id === videoGameId);

  if(confirm(`Delete ${videoGame.title} for the ${videoGame.console}?`)){
    const init = {
      method:"DELETE"
  }

    fetch(`http://localhost:8080/api/video-game/${videoGameId}`,init)
      .then(response =>{
        if(response.status === 200){
          displayGames()
          resetState()
        }else{
          return Promise.reject(`Unexpected status code: ${response.status}`)
        }
      })
      .catch(console.log)
  }
}

function editGame(videoGame){
  videoGame.id = editVideoGameId;
  const init = {
    method: "PUT",
    headers: {
      "Content-type": "application/json"
    },
    body: JSON.stringify(videoGame)
  };
  fetch(`http://localhost:8080/api/video-game/${editVideoGameId}`,init)
    .then(response => {
      if(response.status === 204){
        return null;
      }else if (response.status === 400) {
        return response.json();
      }else{
        return Promise.reject(`Unexpected status code: ${response.status}`)
      }        
    })
    .then(data => {
      if(!data){
        displayGames()
        resetState()
      }else{
        renderErrors(data);
      }
    })
    .catch(console.log)  
}

function handleEditGame(videoGameId){
  const videoGame = videoGames.find(videoGame => videoGame.id === videoGameId);

  document.getElementById("title").value = videoGame.title;
  document.getElementById("console").value = videoGame.console;
  document.getElementById("price").value = videoGame.price;
  document.getElementById("releaseDate").value = videoGame.releaseDate;
  document.getElementById("singlePlayer").value = videoGame.singlePlayer;

  document.getElementById("formHeading").innerHTML = "Update Video Game";
  document.getElementById("formSubmitButton").innerHTML = "Update Video Game";
  
  editVideoGameId = videoGameId;

  setCurrentView("Form");
}

function addGame(videoGame){
  const init = {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(videoGame)
  };
  fetch("http://localhost:8080/api/video-game",init)
    .then(response => {
      if(response.status === 201 || response.status === 400){
        return response.json()
      }else{
        return Promise.reject(`Unexpected status code: ${response.status}`)
      }
    })
    .then(data => {
      if(data.id){
        displayGames()
        resetState()
      }else{
        renderErrors(data);
      }
    })
    .catch(console.log)
}



function setCurrentView(view) {
  switch (view) {
    case 'List':
      formContainerElement.style.display = 'none';
      listContainerElement.style.display = 'block';
      break;
    case 'Form':
      formContainerElement.style.display = 'block';
      listContainerElement.style.display = 'none';
      break;
  }
}

function displayGames(){
  setCurrentView("List");
  fetch("http://localhost:8080/api/video-game")
    .then(response => {
      return response.json();
    })
    .then(data => {
      videoGames = data;
      renderGames(data);
    })
}

function renderGames(videoGames){
  const videoGamesHtml = videoGames.map(videoGame => {
    return `
      <tr>
        <td>${videoGame["title"]}</td>
        <td>${videoGame.console}</td>
        <td>${videoGame["price"]}</td>
        <td>${videoGame["releaseDate"]}</td>
        <td>${videoGame["singlePlayer"] ? "Yes" : "No"}</td>
        <td>
          <div class="float-right mr-2">
            <button class="btn btn-primary btn-sm" onclick="handleEditGame(${videoGame.id})">
              <i class="bi bi-pencil-square"></i> Edit
            </button>
            <button class="btn btn-danger btn-sm" onclick="handleDeleteGame(${videoGame.id})">
              <i class="bi bi-trash"></i> Delete
            </button>
          </div>
        </td>
      </tr>
    `
  });

  const tableBodyElement = document.getElementById("tableRows");
  tableBodyElement.innerHTML = videoGamesHtml.join("")
}


function handleAddGame() {
  setCurrentView('Form');
}

function renderErrors(errors) {
  const errorsHtml = errors.map(error => `<li>${error}</li>`);
  const errorsHtmlString = `
    <div class="alert alert-danger">
      <p>The following errors were found:</p>
      <ul>
        ${errorsHtml.join('')}
      </ul>
    </div>
  `;
  document.getElementById('errors').innerHTML = errorsHtmlString;
}

function resetState() {
  document.getElementById('form').reset();
  document.getElementById('formHeading').innerText = 'Add Video Game';
  document.getElementById('formSubmitButton').innerText = 'Add Video Game';
  document.getElementById('errors').innerHTML = '';
  editVideoGameId = 0;
  setCurrentView('List');
}

displayGames();
