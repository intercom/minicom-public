module.exports = function (req, res, next) {
  res.set({
    'Access-Control-Allow-Origin': '*',
    'Access-Control-Allow-Methods': 'GET, POST, OPTIONS',
    'Access-Control-Allow-Headers': 'Content-Type, Accept',
    'Access-Control-Max-Age': '86400', // 24 hours
  });
  if (req.method === 'OPTIONS') {
    res.send(200);
  } else {
    next();
  }
};
