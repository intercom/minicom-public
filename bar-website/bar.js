class Bar {
  constructor() {
    this.barEndpoint = 'http://localhost:3000/bar';

    $(document).ready(() => {
      this.verify();
    });
  }

  async verify() {
    try {
      let response = await $.post(this.barEndpoint).then();
      if (response.success === true) {
        alert('Yay! Everything works');
      } else {
        alert('Unexpected response');
      }
    } catch (error) {
      alert('There has been a problem with the request');
    }
  }
}
