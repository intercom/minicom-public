class Foo {
  constructor() {
    this.fooEndpoint = 'http://localhost:3000/foo';

    $(document).ready(() => {
      this.verify();
    });
  }

  async verify() {
    try {
      let response = await $.post(this.fooEndpoint).then();
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
