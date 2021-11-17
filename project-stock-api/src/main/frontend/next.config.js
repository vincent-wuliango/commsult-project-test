module.exports = {
  reactStrictMode: true,
  env: {
    appName: "Project Test Commsult",
  },

  async rewrites() {
    return [
      {
        source: "/home",
        destination: "/",
      },
      {
        source: "/login",
        destination: "/auth/", 
      },
    ];
  },
};
