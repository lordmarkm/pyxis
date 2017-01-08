({
  mainConfigFile : "${basedir}/src/main/webapp/main.js",
  baseUrl: '${basedir}/src/main/webapp',
  dir: "${basedir}/target/webapp-build",
  optimize: '${js.optimize}',
  optimizeCss: '${css.optimize}',
  removeCombined: true,
  modules: [
            {
              name: "main"
            }
          ]
})