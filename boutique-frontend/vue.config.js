const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = {
    devServer: {
        proxy: {
            '/*': {
                target: 'http://10.0.2.2:5245',
                changeOrigin: true,
                secure: false, // set to true if your endpoint is HTTPS
                pathRewrite: {
                    '^/api': '/WeatherForecast/Rooms'
                }
            }
        }
    }
};