loadSongsMenu();
var songDataList = [];
var responseText = [];

document.getElementById('actArtist').addEventListener('click', addArtistFields);

document.getElementById('actAlbum').addEventListener('click', function () {
    const album = `
    <input class="form-control" id="album" placeholder="Album" type="text">
    `;
    document.getElementById('albumField').innerHTML += album;
    document.getElementById('actAlbum').style.display = 'none';
});

function addArtistFields() {
    const artistType = `
        <select class="custom-select">
            <option selected>Choose...</option>
            <option value="SOLO">Solo</option>
            <option value="DUO">Duo</option>
            <option value="BAND">Band</option>
        </select>`;
    document.getElementById('artistType').innerHTML += artistType;

    const artist = `
    <input class="form-control" id="artist" placeholder="Artist" type="text">`;
    document.getElementById('artistField').innerHTML += artist;
    document.getElementById('actArtist').style.display = 'none';
}

function loadSongsMenu() {
    apiCall('song/random');
    if (JSON.parse(responseText)) {
        songDataList = JSON.parse(responseText);
        const songList = document.getElementById('songData');
        songDataList.forEach(song => {
            const data = `<tr class="table-light" style="background-color: rgba(225, 225, 225, 0.8)">
            <a href="./song-detail.html?id=${song.id}" id="selectedSong" style="color:black">
                    <p>Title: ${song.title}<br>
                    Artist: ${song.artist} <br>
                    Album:  ${song.album} <br></p>
                    </a></tr>
            `;
            window.sessionStorage.setItem('id', JSON.stringify(song));
            songList.innerHTML += data;
        })
    }
}

function apiCall(entity) {
    let url = "http://localhost:8080/musiQ_library/api/";
    let newUrl = url + entity.toLowerCase();
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            responseText = this.responseText;
        }
    };
    xhttp.open('GET', newUrl, false);
    xhttp.send();
}

function loadArtist() { //TODO
    let xhttp = new XMLHttpRequest();
    if (this.readyState == 4 && this.status == 200) {
        let artistList = JSON.parse(this.responseText);
        let artist = '<div class="row">';

        for (index = 0; index < 4; index++) {
            artist +=
                '<a href="#">' +
                '<p>' + artistList[index].artistName + '</p>' +
                '</a>'
            ;
        }
        artist += '</div>';
        document.getElementById("artistData").innerHTML = artist;
    }
    xhttp.open("GET", apiCall("artist") + "list");
    xhttp.send();
}

function loadAlbums() { //TODO
    let xhttp = new XMLHttpRequest();
    if (this.readyState == 4 && this.status == 200) {
        let albumList = JSON.parse(this.responseText);
    }
    xhttp.open("GET", apiCall("album") + "list");
    xhttp.send();
}
