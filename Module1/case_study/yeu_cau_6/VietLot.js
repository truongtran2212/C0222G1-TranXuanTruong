
/*
 Xây dựng ứng dụng cho phép khách hàng thực hiện mua vé số tương tự VIETLOT, mỗi vé sẽ bao gồm 6 số nguyên dương, có thể mua tối đa 4 vé.
 Viết chương trình cho phép người dùng mua vé số. Sẽ có hai tuỳ chọn cho khách hàng thực hiện chọn số trên mỗi vé.
    - Nếu khách hàng chọn tự nhập thì cứ mỗi ô tròn KH click vào sẽ hiển thị 1 bảng chọn số từ 0-99
    - Nếu khách hàng chọn tuỳ chọn random thì hệ thống sẽ tự động tạo ra 6 số tương ứng 6 ô tròn
Sau khi khách hàng hoàn tất việc chọn số trên vé thì nhấn hoàn tất để thực hiện quay số
Hệ thống sẽ so khớp dãy số trên vé với dãy số của hệ thống xem KH có trúng thưởng không
Sẽ có 3 giải bao gồm:
    Giải nhất: 6 số trên vé của KH trùng khớp hoàn toàn với 6 số của hệ thống
    Giải nhì: 5 số cuối của vé KH trùng khớp với 5 số cuối của hệ thống
    Giải khuyến khích: 3 số cuối của vé KH trùng khớp với 3 số cuối của hệ thống
Khi KH may mắn trúng giải nào thì hệ thống sẽ hiển thị kết quả là số tiền sẽ nhận được tương ứng (HV tự defined)
Khi KH không trúng giải nào thì hệ thống hiển thị thông báo “Chúc bạn may mắn lần sau”
*/

var listTicket = [];
var listResultTicket = [];

class Vietlot {
    constructor(no1, no2, no3, no4, no5, no6) {
        this.no1 = no1;
        this.no2 = no2;
        this.no3 = no3;
        this.no4 = no4;
        this.no5 = no5;
        this.no6 = no6;
    }
}

// mua vé
function ticket() {
    // 1 : tự chọn - 2 : tự động
    let option = Number(prompt("Bạn có 2 lựa chọn \n1. Bạn muốn tự chọn số. \n2. Hệ thống tự random."));
    if (option === 1) {
        let qty = Number(prompt("Bạn muốn mua mấy vé (tối đa 4 vé)"));
        if (qty > 0 && qty <= 4) {
            setManual(qty);
            setResultTicket(qty);
        } else if (qty <= 0) {
            alert("Bạn phải chọn số lượng vé cần mua từ 1 đến 4 vé")
        } else {
            alert("Bạn chỉ mua được tối đa 4 vé")
        }
    } else if (option === 2) {
        let qty = Number(prompt("Bạn muốn mua mấy vé (tối đa 4 vé)"));
        if (qty > 0 && qty <= 4) {
            setAuto(qty);
            setResultTicket(qty);
        } else if (qty <= 0) {
            alert("Bạn phải chọn số lượng vé cần mua từ 1 đến 4 vé")
        } else {
            alert("Bạn chỉ mua được tối đa 4 vé")
        }
    } else {
        alert("Bạn đã chọn sai phương thức mua vé");
    }
}

// hiển thị vé đã chọn
function showTicket() {
    let table = '';
    for (let index = 0; index < listTicket.length; index++) {
        table += ` <tr>
            <td>Cặp số ` + (index + 1) + `:</td>
            <td class="number">` + listTicket[index].no1 + `</td>
            <td class="number">` + listTicket[index].no2 + `</td>
            <td class="number">` + listTicket[index].no3 + `</td>
            <td class="number">` + listTicket[index].no4 + `</td>
            <td class="number">` + listTicket[index].no5 + `</td>
            <td class="number">` + listTicket[index].no6 + `</td>
        </tr>`;
    }
    document.getElementById("tickets").innerHTML = table;
}

// hiển thị kết quả
function showResult() {
    let table = '';
    for (let index = 0; index < listResultTicket.length; index++) {
        table += ` <tr>
            <td>Cặp số ` + (index + 1) + `:</td>
            <td class="number">` + listResultTicket[index].no1 + `</td>
            <td class="number">` + listResultTicket[index].no2 + `</td>
            <td class="number">` + listResultTicket[index].no3 + `</td>
            <td class="number">` + listResultTicket[index].no4 + `</td>
            <td class="number">` + listResultTicket[index].no5 + `</td>
            <td class="number">` + listResultTicket[index].no6 + `</td>
        </tr>`;
    }
    document.getElementById("result").innerHTML = table;
}

// tự động random
function setAuto(qty) {
    for (let i = 1; i <= qty; i++) {
        for (let j = 1; j <= 6; j++) {
            switch (j) {
                case 1:
                    var no1 = Math.floor(Math.random() * 100);
                    break;
                case 2:
                    var no2 = Math.floor(Math.random() * 100);
                    break;
                case 3:
                    var no3 = Math.floor(Math.random() * 100);
                    break;
                case 4:
                    var no4 = Math.floor(Math.random() * 100);
                    break;
                case 5:
                    var no5 = Math.floor(Math.random() * 100);
                    break;
                case 6:
                    var no6 = Math.floor(Math.random() * 100);
                    break;
            }
        }
        let ticketNumber = new Vietlot(no1, no2, no3, no4, no5, no6);
        listTicket.push(ticketNumber);
    }
    showTicket();
}

// chọn vé thủ công
function setManual(qty) {
    for (let i = 1; i <= qty; i++) {
        for (let j = 1; j <= 6; j++) {
            switch (j) {
                case 1:
                    var no1 = Number(prompt("Nhập cặp số thứ " + i + " lần 1"));
                    break;
                case 2:
                    var no2 = Number(prompt("Nhập cặp số thứ " + i + " lần 2"));
                    break;
                case 3:
                    var no3 = Number(prompt("Nhập cặp số thứ " + i + " lần 3"));
                    break;
                case 4:
                    var no4 = Number(prompt("Nhập cặp số thứ " + i + " lần 4"));
                    break;
                case 5:
                    var no5 = Number(prompt("Nhập cặp số thứ " + i + " lần 5"));
                    break;
                case 6:
                    var no6 = Number(prompt("Nhập cặp số thứ " + i + " lần 6"));
                    break;
            }
        }
        let ticketNumber = new Vietlot(no1, no2, no3, no4, no5, no6);
        listTicket.push(ticketNumber);
    }
    showTicket();
}

// tự động random kết quả
function setResultTicket(qty) {
    for (let i = 1; i <= qty; i++) {
        for (let j = 1; j <= 6; j++) {
            switch (j) {
                case 1:
                    var no1 = Math.floor(Math.random() * 100);
                    break;
                case 2:
                    var no2 = Math.floor(Math.random() * 100);
                    break;
                case 3:
                    var no3 = Math.floor(Math.random() * 100);
                    break;
                case 4:
                    var no4 = Math.floor(Math.random() * 100);
                    break;
                case 5:
                    var no5 = Math.floor(Math.random() * 100);
                    break;
                case 6:
                    var no6 = Math.floor(Math.random() * 100);
                    break;
            }
        }
        let ticketNumber = new Vietlot(no1, no2, no3, no4, no5, no6);
        listResultTicket.push(ticketNumber);
    }
}

// kiểm tra kết quả
function checkResult() {
    setResultTicket();
    showResult();
    for (let i = 0; i < listTicket.length; i++) {
        if (
            listTicket[i].no1 === listResultTicket[i].no1 &&
            listTicket[i].no2 === listResultTicket[i].no2 &&
            listTicket[i].no3 === listResultTicket[i].no3 &&
            listTicket[i].no4 === listResultTicket[i].no4 &&
            listTicket[i].no5 === listResultTicket[i].no5 &&
            listTicket[i].no6 === listResultTicket[i].no6
        ) {
            document.getElementById("messResult").innerText = "Chúc mừng bạn đã trúng giải nhất";
        } else if
        (
            listTicket[i].no2 === listResultTicket[i].no2 &&
            listTicket[i].no3 === listResultTicket[i].no3 &&
            listTicket[i].no4 === listResultTicket[i].no4 &&
            listTicket[i].no5 === listResultTicket[i].no5 &&
            listTicket[i].no6 === listResultTicket[i].no6
        ) {
            document.getElementById("messResult").innerText = "Chúc mừng bạn đã trúng giải nhì";
        } else if
        (
            listTicket[i].no4 === listResultTicket[i].no4 &&
            listTicket[i].no5 === listResultTicket[i].no5 &&
            listTicket[i].no6 === listResultTicket[i].no6
        ) {
            document.getElementById("messResult").innerText = "Chúc mừng bạn đã trúng giải khuyến khích";
        } else {
            document.getElementById("messResult").innerText = "Chúc bạn may mắn lần sau";
        }
    }
    // Giải nhất: 6 số trên vé của KH trùng khớp hoàn toàn với 6 số của hệ thống
    // Giải nhì: 5 số cuối của vé KH trùng khớp với 5 số cuối của hệ thống
    // Giải khuyến khích: 3 số cuối của vé KH trùng khớp với 3 số cuối của hệ thống
}

