loadAllSongs();
var responseText = [];

function loadAllSongs() {
    apiCall('song/list');
    if (JSON.parse(responseText)) {
        songDataList = JSON.parse(responseText);
        const songList = document.getElementById('songTable');
        songDataList.forEach(song => {
            const data = `
            <tr class="table-light" style="background-color: rgba(225, 225, 225, 0.8)">
                    <td id="song">
                        <a href="./song-detail.html?id=${song.id}" style="color:black"">${song.title}</a>
                     </td>
                    <td id="artist">${song.artist}</td>
                    <td id="album">${song.album.albumTitle}</td></tr>
            `;
            window.sessionStorage.setItem(`${song.id}`, JSON.stringify(song));
            songList.innerHTML += data;
        });
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
