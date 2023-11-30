document.addEventListener('DOMContentLoaded', () => {
	const hero = document.querySelector('.hero');
	const header = document.querySelector('.header');
	const scrollItems = document.querySelectorAll('.scroll-item');
	const submit = document.querySelector('#submit');


	const scrollAnimation = () => {
		let windowCenter = (window.innerHeight / 2) + window.scrollY;
		// console.log(windowCenter)
		scrollItems.forEach(el => {
			let scrollOffset = el.offsetTop + (el.offsetHeight / 2);
			console.log(scrollOffset)
			if (windowCenter >= scrollOffset) {
				el.classList.add('animation-class');
			} else {
				el.classList.remove('animation-class');
			}
		});
	};

	const headerFixed = () => {
		let scrollTop = window.scrollY;
		let heroCenter = hero.offsetHeight / 2;

		if (scrollTop >= heroCenter) {
			header.classList.add('fixed')
			hero.style.marginTop = `${header.offsetHeight}px`;
		} else {
			header.classList.remove('fixed')
			hero.style.marginTop = `0px`;
		}
	};

	headerFixed();
	scrollAnimation();
	window.addEventListener('scroll', () => {
		headerFixed();
		scrollAnimation();
	});


	const saveLead = async () => {

		let clientName=document.getElementById("recipient-name").value
		let clientMobile=document.getElementById("mobile").value

		//let response = await fetch('http://localhost:8080/lead/getLeads');
		let response2 = await fetch('http://localhost:8080/lead/save', {
			method: 'POST',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({
				name: clientName,
				mobile:clientMobile
			})
		})
		//console.log(response2);
		//console.log(response);
		document.getElementById('myForm').reset(); // clear the Sign-up form
		$('#exampleModalCenter').modal('toggle'); //close the form

		$('#exampleModal').modal('toggle'); // Thank you form

	}
	submit.addEventListener('click', saveLead);
});



