loadAllSongs();
var responseText = [];

function loadAllSongs() {
    apiCall('song/list');
    if (JSON.parse(responseText)) {
        songDataList = JSON.parse(responseText);
        const songList = document.getElementById('allSongs');
        songDataList.forEach(song => {
            const data = `
            <tr class="table-light" style="background-color: rgba(225, 225, 225, 0.8)">
            <a href="./song-detail.html?id=${song.id}" style="color:black"">
                    <p>Title: ${song.title}<br>
                    Artist: ${song.artist} <br>
                    Album:  ${song.album} <br></p>
                    </a></tr>
            `;
            window.sessionStorage.setItem('id', JSON.stringify(song));
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
