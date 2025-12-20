class AdminApp {
  constructor() {
    this.userEndpoint = 'http://localhost:3001/admin_api/users';
    this.sendMessageEndpoint = 'http://localhost:3001/admin_api/messages';
    this.selectedUserId = null;
    this.selectedUserEmail = null;
    $(document).ready(() => {
      this.loadUsers();


      document.getElementById('message-submit').onclick = (event) =>
          event.preventDefault() || this.sendMessage();
    });
  }


  setReceiver(context) {
    let dataAttributes = context.dataset;
    this.selectedUserEmail = dataAttributes.userEmail;
    this.selectedUserId = dataAttributes.userId;
    document.getElementById('message-receiver').value = dataAttributes.userEmail;
  }


  loadUsers() {
    $.get(this.userEndpoint).done((users) => {
      users.forEach((user) => this.addUserToList(user));
    });
  }


  addUserToList(user) {
    let userList = document.getElementById('user-list');
    let listItem = document.createElement('li');
    let userEmail = document.createTextNode(user.email);


    listItem.setAttribute('data-user-id', user.id);
    listItem.setAttribute('data-user-email', user.email);
    listItem.classList.add('list-group-item');
    listItem.onclick = () => this.setReceiver(listItem);


    listItem.appendChild(userEmail);
    userList.appendChild(listItem);
  }


  sendMessage() {
    let message = {
      content: document.getElementById('message-content').value,
      user_id: this.selectedUserId,
      email: this.selectedUserEmail,
    };


    return $.post(this.sendMessageEndpoint, message);
  }
}