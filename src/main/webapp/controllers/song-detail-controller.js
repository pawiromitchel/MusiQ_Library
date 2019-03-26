getSongDetail();

function getSongDetail() {
    let urlParams = window.location.search.substring(1).split("=");
    let item = window.sessionStorage.getItem(urlParams[1]);
    const data = JSON.parse(item);
    setSongDetail(data)
}


function setSongDetail(song) {
    let songDetail = document.getElementById('songDetail');
    let detail = `
        <h4>Song: ${song.title}</h4>
            <h5>Artist: ${song.album.artist.artistName}</h5>
            <h5>Album: ${song.album.albumTitle}</h5>
        `;
    songDetail.innerHTML += detail;
}
