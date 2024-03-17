import { useState } from 'react';


function Comic({title,artist,release,imgSrc,imgAlt}){
    //likes is the state variable and setLikes updates the state variable
    const [likes, setLikes] = useState(0);

    return(
        <div className="comic">
            <h2>{title === undefined ? "Name me plz..." : title}</h2>
            <img src={imgSrc} alt={imgAlt} width="275"/>
            <h3>Artist: {artist || "Unknown Artist"}</h3>
            <h3>Release Date: {release || "Unknown Release Date"}</h3>
            <img src="./pics/thumbsup.png" width="30" alt="Like Comic"
                className="thumbsUp"
                onClick={()=>setLikes(likes + 1)}/>
            <br/>
            {likes || "Click button to like"}
        </div>        
    )
}

export default Comic;