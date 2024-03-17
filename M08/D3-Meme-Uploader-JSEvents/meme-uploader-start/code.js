let memes = [];

let titleVar = document.getElementById("title");
let uploaderVar = document.getElementById("uploader");
let memeUploadVar = document.getElementById("memeUpload");
let memeContainer = document.getElementById("memes");
let memeIndexVar = document.getElementById("memeIndex");

let uploadMemeFormVar = document.getElementById("uploadMemeForm");
let deleteMemeFormVar = document.getElementById("deleteMemeForm");

deleteMemeFormVar.addEventListener("submit",(event) =>{
    event.preventDefault();
    let memePosition = parseInt(memeIndexVar.value - 1);
    memes[memePosition] = undefined;
    //delete memes[memePosition];
    //memes.splice(memePosition,1);
    showMemes();
})

uploadMemeFormVar.addEventListener("submit",(event)=>{
    event.preventDefault();
    let memeTitle = titleVar.value;
    let memeUploader = uploaderVar.value;
    let uploadedMeme = memeUploadVar.files[0];

    memes.push({
        title: memeTitle,
        uploader:memeUploader,
        meme: uploadedMeme 
    });

    showMemes();
})

function showMemes(){
    let html = "";
    for(let i = 0; i < memes.length; i++){
        if(!memes[i]){
            continue;
        }
        html +=
        `
        <div>
            <h3>${i+1} - ${memes[i].title}</h3>
            <img src="${URL.createObjectURL(memes[i].meme)}" 
                alt="${memes[i].title}" width="300">
            <br>
            Uploaded by: ${memes[i].uploader}
        </div>
        `
    }
    memeContainer.innerHTML = html;
}


var keyBoardInput = '';
// up, up, down, down, left, right, left, right, b, a, enter
var code = 'ArrowUpArrowUpArrowDownArrowDownArrowLeftArrowRightArrowLeftArrowRightbaEnter';

document.addEventListener("keydown", e =>{
    keyBoardInput += e.key;
    if(keyBoardInput === code){
        let contra = new Audio("sounds/contra.mp3");
        contra.play();
        document.querySelector(".contra").innerHTML = 
        `
            <marquee behavior="scroll" direction="left" 
                loop="1" scrollamount="22">
                This code unlocks life. Nice job finding it! (:
            </marquee>
        `
    }
})
