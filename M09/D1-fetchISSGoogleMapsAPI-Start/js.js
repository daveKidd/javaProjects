/* API URL: https://wheretheiss.at/w/developer    
   Data URL: https://api.wheretheiss.at/v1/satellites/25544 
*/

async function initMap() {
   const response = await fetch("https://api.wheretheiss.at/v1/satellites/25544")
   const data = await response.json()

   let lat = parseFloat(data.latitude.toFixed(4));
   let long = parseFloat(data.longitude.toFixed(4));

   let location = { lat: lat, lng: long };

   let map = new google.maps.Map(document.getElementById("map"), {
      zoom: 3,
      center: location
   })

   let marker = new google.maps.Marker({
      position: location,
      map: map,
      icon: {
         url: "ss.png",
         scaledSize: new google.maps.Size(60, 60)
      }
   })

   let lastUpdated = document.getElementById("lastUpdated")
   let loc = document.getElementById("loc")
   let date, hours, minutes, updatedTime

   setInterval(function () {
      fetch("https://api.wheretheiss.at/v1/satellites/25544")
         .then(response => response.json())
         .then(data => {
            lat = parseFloat(data.latitude.toFixed(4))
            long = parseFloat(data.longitude.toFixed(4))
            
            date = new Date(data.timestamp * 1000);
            hours = date.getHours();
            minutes = `0${date.getMinutes()}`;
            updatedTime = hours > 12 ? `${hours - 12}:${minutes.substr(-2)} PM` :
               hours === 12 ? `${hours}:${minutes.substr(-2)} PM` : `${hours}:${minutes.substr(-2)} AM`

            lastUpdated.innerHTML = `Last Updated: ${updatedTime}`
            loc.innerHTML = `Latitude: ${lat}<br>Longitude: ${long}`
            map.panTo({lat:lat, lng:long})
            marker.setPosition({lat:lat, lng:long})
         })
   }, 1500)
}



