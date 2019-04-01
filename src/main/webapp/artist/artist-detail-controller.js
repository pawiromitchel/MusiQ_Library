getArtistDetail();

function getArtistDetail() {
    let urlParams = window.location.search.substring(1).split("=");
    let item = window.sessionStorage.getItem(urlParams[1]);
    const data = JSON.parse(item);
    setArtistDetail(data)
}


function setArtistDetail(artist) {
    let artistDetail = document.getElementById('artistDetail');
    let detail = `
        <button type="button" class="btn btn-outline-dark btn-dark" style="margin: 10px">
                <a href="#" onclick="history.back()"><i class="fas fa-arrow-left"> </i></a>
            </button>
            <h4>Artist: ${artist.artistName}</h4>
            <h5>Artist Type: ${artist.artistType.artistType}</h5>
            <h5>Album: ${artist.album}</h5>
        `;
    artistDetail.innerHTML += detail;
    if (artist.artistInfo) {
        let info = `
        <h5>Artist Info: </h5><textarea rows="9" cols="70" disabled style="background-color: white; height: 200px;
                margin: 5px"> ${artist.artistInfo.info}</textarea>
        `;
        artistDetail.innerHTML += info;
    }
}
