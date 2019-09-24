const compose = (...fns) =>
  fns.reduceRight((prevFn, nextFn) =>
    (...args) => nextFn(prevFn(...args)),
    value => value
  );
   
const toUpperCase = x => x.toUpperCase();
const exclaim = x => `${x}!`;
const hashtag = x => `#${x}`;
const head = x => x.shift();
const reverse = x => x.reverse();
const shoutHashtag = compose(toUpperCase, hashtag , exclaim);
const lastItemUpperCase  = compose(toUpperCase, head, reverse);
shoutHashtag('xd') // #XD!
lastItemUpperCase(["z", "y", "x", "w", "v"]); // V
