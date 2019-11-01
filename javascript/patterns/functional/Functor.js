const Functor = value => ({
 value,
 map: morphism => Functor(morphism(value))
});

const userNameToUserAPI = (username) => `http://foo.com/api/user/${username}`;
const functor = Functor("INFLUENZ");
const morphed = functor.map(userNameToUserAPI);

/* {
  map: morphism => Functor(morphism(value)),
  value: "http://foo.com/api/user/INFLUENZ"
} */
