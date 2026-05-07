// ================== CONFIG ==================
const API = "https://hostel-management-system-4-223l.onrender.com";

// ================== BASIC API ==================
async function GET(path) {
  const res = await fetch(API + path);
  if (!res.ok) throw new Error("GET failed");
  return res.json();
}

async function POST(path, body) {
  const res = await fetch(API + path, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(body)
  });

  if (!res.ok) throw new Error("POST failed");
  return res.json().catch(() => null);
}

async function DELETE_REQ(path) {
  const res = await fetch(API + path, {
    method: "DELETE"
  });

  if (!res.ok) throw new Error("DELETE failed");
}

// ================== STUDENTS ==================
async function addStudentSimple() {

  const student = {
    name: document.getElementById("name").value,
    admissionYear: parseInt(document.getElementById("year").value),
    roomNo: 0,
    dept: document.getElementById("dept").value
  };

  if (!student.name) {
    alert("Name required");
    return;
  }

  try {
    await POST("/students", student);
    loadStudents();
  } catch (e) {
    alert("Error adding student");
  }
}

async function loadStudents() {
  try {
    const students = await GET("/students");

    const container = document.getElementById("studentsList");
    if (!container) return;

    container.innerHTML = students.map(s => `
      <div class="card">
        <p><b>ID:</b> ${s.id}</p>
        <p><b>Name:</b> ${s.name}</p>
        <p>${s.dept} | Year: ${s.admissionYear}</p>
        <p><b>Room:</b> ${s.roomNo}</p>

        <button onclick="deleteStudent(${s.id})">Delete</button>
      </div>
    `).join("");

  } catch (e) {
    console.error(e);
  }
}

async function deleteStudent(id) {
  if (!confirm("Delete student?")) return;

  try {
    await DELETE_REQ("/students/" + id);
    loadStudents();
  } catch (e) {
    alert("Delete failed");
  }
}

// ================== ROOMS ==================
let allRooms = [];

async function loadRooms() {
  try {
    const rooms = await GET("/rooms");
    allRooms = rooms;
    displayRooms(rooms);
  } catch (e) {
    console.error(e);
  }
}

function displayRooms(rooms) {
  const container = document.getElementById("roomList");
  if (!container) return;

  container.innerHTML = rooms.map(r => {
    const isFull = r.occupied >= r.capacity;

    return `
      <div class="card">
        <h3>Room ${r.roomNo}</h3>
        <p>${r.occupied}/${r.capacity}</p>
        <p style="color:${isFull ? '#e74c3c' : '#2ecc71'}">
          ${isFull ? "Full" : "Available"}
        </p>
      </div>
    `;
  }).join("");
}

async function addRoom() {
  const room = {
    roomNo: parseInt(document.getElementById("roomNo").value),
    capacity: parseInt(document.getElementById("capacity").value),
    occupied: 0
  };

  try {
    await POST("/rooms", room);
    loadRooms();
  } catch (e) {
    alert("Error adding room");
  }
}

// ================== ALLOCATION ==================
async function allocateStudent() {

  const studentId = document.getElementById("studentId").value;
  const roomNo = document.getElementById("roomNo").value;

  try {
    const res = await fetch(`${API}/students/allocate?studentId=${studentId}&roomNo=${roomNo}`, {
      method: "POST"
    });

    if (!res.ok) throw new Error();

    alert("Allocated successfully");

  } catch (e) {
    alert("Allocation failed");
  }
}

// ================== AUTO LOAD ==================
window.onload = () => {
  if (document.getElementById("studentsList")) loadStudents();
  if (document.getElementById("roomList")) loadRooms();
};