const compose = (...fns) =>
  fns.reduceRight((prevFn, nextFn) =>
    (...args) => nextFn(prevFn(...args)),
    value => value
  );
   
const toUpperCase = x => x.toUpperCase();
const exclaim = x => `${x}!`;
const hashtag = x => `#${x}`;
const shoutHashtag = compose(toUpperCase, hashtag , exclaim);

shoutHashtag('xd') // #XD!
