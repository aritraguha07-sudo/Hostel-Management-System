// ====================== STUDENTS ======================

function getStudents() {
    return JSON.parse(localStorage.getItem("students")) || [];
}

function saveStudents(students) {
    localStorage.setItem("students", JSON.stringify(students));
}

function addStudentSimple() {

    const name = document.getElementById("name").value;
    const year = document.getElementById("year").value;
    const dept = document.getElementById("dept").value;

    if (!name) {
        alert("Enter name");
        return;
    }

    const students = getStudents();

    students.push({
        id: Date.now(),
        name,
        admissionYear: year,
        dept,
        roomNo: 0
    });

    saveStudents(students);

    document.getElementById("name").value = "";
    document.getElementById("year").value = "";
    document.getElementById("dept").value = "";

    loadStudents();
}

function loadStudents() {

    const container = document.getElementById("studentsList");
    if (!container) return;

    const students = getStudents();

    if (students.length === 0) {
        container.innerHTML = "<p>No students added yet.</p>";
        return;
    }

    container.innerHTML = students.map(s => `
        <div class="card">
            <p><b>ID:</b> ${s.id}</p>
            <p><b>Name:</b> ${s.name}</p>
            <p><b>Department:</b> ${s.dept}</p>
            <p><b>Year:</b> ${s.admissionYear}</p>
            <p><b>Room:</b> ${s.roomNo}</p>

            <button onclick="deleteStudent(${s.id})">
                Delete
            </button>
        </div>
    `).join("");
}

function deleteStudent(id) {

    let students = getStudents();

    students = students.filter(s => s.id !== id);

    saveStudents(students);

    loadStudents();
}

// ====================== ROOMS ======================

function getRooms() {
    return JSON.parse(localStorage.getItem("rooms")) || [];
}

function saveRooms(rooms) {
    localStorage.setItem("rooms", JSON.stringify(rooms));
}

function addRoom() {

    const roomNo = document.getElementById("roomNo").value;
    const capacity = document.getElementById("capacity").value;

    if (!roomNo || !capacity) {
        alert("Fill all fields");
        return;
    }

    const rooms = getRooms();

    rooms.push({
        roomNo,
        capacity,
        occupied: 0
    });

    saveRooms(rooms);

    document.getElementById("roomNo").value = "";
    document.getElementById("capacity").value = "";

    loadRooms();
}

function loadRooms() {

    const container = document.getElementById("roomList");
    if (!container) return;

    const rooms = getRooms();

    if (rooms.length === 0) {
        container.innerHTML = "<p>No rooms added yet.</p>";
        return;
    }

    container.innerHTML = rooms.map(r => `
        <div class="card">
            <h3>Room ${r.roomNo}</h3>
            <p>Capacity: ${r.capacity}</p>
            <p>Occupied: ${r.occupied}</p>
        </div>
    `).join("");
}

// ====================== PAGE LOAD ======================

window.onload = () => {

    if (document.getElementById("studentsList")) {
        loadStudents();
    }

    if (document.getElementById("roomList")) {
        loadRooms();
    }
};